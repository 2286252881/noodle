package com.noodle.process.exception;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.process.result.ResultInfo;

public class ExceptionResolverCustom implements HandlerExceptionResolver {

	private HttpMessageConverter<ExceptionResultInfo> jsonMessageConverter;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// 输出异常信息
		ex.printStackTrace();
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		// 判断是否返回json(只要方法上包含responseBody注解，就表示返回json):查找方法是否包含@ResponseBody注解
		ResponseBody responseBody = AnnotationUtils.findAnnotation(method, ResponseBody.class);

		ExceptionResultInfo exceptionResultInfo = resoverExceptionCustom(ex);
		if (responseBody != null) {
			return resolveJsonException(request, response, handler, ex);
		}

		// 业务异常
		String view =exceptionResultInfo.getResultInfo().getView();
		// 000：shiro权限不通过
		if (000 == exceptionResultInfo.getResultInfo().getMessageCode()) {
			exceptionResultInfo.getResultInfo().setView("/base/refuse");
			view=exceptionResultInfo.getResultInfo().getView();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exceptionResultInfo", exceptionResultInfo.getResultInfo().getMessage());
		modelAndView.setViewName(view);
		return modelAndView;
	}

	// 异常信息解析方法
	private ExceptionResultInfo resoverExceptionCustom(Exception ex) {
		ResultInfo resultInfo = null;
		if (ex instanceof ExceptionResultInfo) {
			resultInfo = ((ExceptionResultInfo) ex).getResultInfo();
		} else if (ex instanceof UnauthorizedException) {
			resultInfo = new ResultInfo();
			resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
			resultInfo.setMessageCode(000);// shiro认证异常
			resultInfo.setMessage("对不起，您没有该访问权限!");
		} else {
			resultInfo = new ResultInfo();
			resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
			resultInfo.setMessage("未知异常!");
		}
		return new ExceptionResultInfo(resultInfo);
	}

	// 如果有@responsebody注解，将不是json的异常信息转json
	private ModelAndView resolveJsonException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ExceptionResultInfo exceptionResultInfo = resoverExceptionCustom(ex);
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
		try {
			jsonMessageConverter.write(exceptionResultInfo, MediaType.APPLICATION_JSON, outputMessage);
		} catch (HttpMessageNotWritableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}

	public HttpMessageConverter<ExceptionResultInfo> getJsonMessageConverter() {
		return jsonMessageConverter;
	}

	public void setJsonMessageConverter(HttpMessageConverter<ExceptionResultInfo> jsonMessageConverter) {
		this.jsonMessageConverter = jsonMessageConverter;
	}
}

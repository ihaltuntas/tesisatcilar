package serviceprovider.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.provider.client.executor.ServiceClient;
import service.provider.common.request.GetAllProvidersRequestDto;
import service.provider.common.request.RequestDtoFactory;
import service.provider.common.response.GetAllProvidersResponseDto;

@Controller
public class MainController {

	@RequestMapping(value = "/main.do")
	public Object showMainPage() {
		ModelAndView modelAndView = new ModelAndView("main");
		GetAllProvidersRequestDto requestDto = RequestDtoFactory.createGetAllProvidersRequestDto();
		GetAllProvidersResponseDto response = ServiceClient.getAllProviders(requestDto);
//		Cok onemli bir commit geliyor
		modelAndView.addObject("gokhanUsta", response.toString());
		return modelAndView;
	}

}

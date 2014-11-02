package serviceprovider.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.provider.client.executor.ServiceClient;
import service.provider.common.dto.ProviderDto;
import service.provider.common.request.GetAllProvidersRequestDto;
import service.provider.common.request.RequestDtoFactory;
import service.provider.common.request.SaveProviderRequestDto;
import service.provider.common.response.GetAllProvidersResponseDto;
import service.provider.common.response.SaveProviderResponseDto;

@Controller
public class MainController {

	@RequestMapping(value = "/main.do")
	public Object showMainPage() {
		ModelAndView modelAndView = new ModelAndView("main");
		GetAllProvidersRequestDto requestDto = RequestDtoFactory.createGetAllProvidersRequestDto();
		GetAllProvidersResponseDto response = ServiceClient.getAllProviders(requestDto);
		SaveProviderRequestDto saveProviderRequestDto = RequestDtoFactory.createSaveProviderRequestDto();
		ProviderDto providerDto = new ProviderDto();
		saveProviderRequestDto.setProviderDto(providerDto);
		
		//cmoüt 2
		modelAndView.addObject("gokhanUsta", response.toString());
		return modelAndView;
	}

}

package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.dto.ComercialDTO;
import org.iesvdm.exception.MiExcepcion;
//import org.iesvdm.mapstruct.ComercialMapper;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /comerciales como
//prefijo.
//@RequestMapping("/comerciales")
public class ComercialController {
	
	private ComercialService comercialService;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialController(ComercialService comercialService) {
		this.comercialService = comercialService;
	}
	
	//@RequestMapping(value = "/comerciales", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/comerciales") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Comercial> listaComerciales =  comercialService.listAll();
		model.addAttribute("listaComerciales", listaComerciales);
				
		return "comerciales";
		
	}
	

	@GetMapping("/comerciales/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		ComercialDTO comercial = comercialService.oneDTO(id);
		model.addAttribute("comercial", comercial);
		
		
		return "detalle-comercial";
		
	}
	
	
	@GetMapping("/comerciales/crear")
	public String crear(Model model){
		
		Comercial comercial = new Comercial();
		model.addAttribute("comercial", comercial);
		
		return "crear-comercial";
		
	}
	
	@PostMapping("/comerciales/crear")
	public String submitCrear(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult bindingResulted, Model model) {
		
		String view;
		
		if(bindingResulted.hasErrors()) {
			view = "crear-comercial";
			model.addAttribute(comercial);
		} else {
			comercialService.newComercial(comercial);
			view= "redirect:/comerciales";
		}
				
		return view;	
	}
	
	@GetMapping("/comerciales/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		
		Comercial comercial = comercialService.one(id);
		model.addAttribute("comercial", comercial);
		
		return "editar-comercial";
	}
	
	@PostMapping("/comerciales/editar/{id}")
	public String submitEditar(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult bindingResulted, Model model) {
		
		String view;
		
		if(bindingResulted.hasErrors()) {
			view = "editar-comercial";
			model.addAttribute(comercial);
		}else {
			comercialService.replaceComercial(comercial);
			view = "redirect:/comerciales";
		}	
		
		return view;
	}
	
	@PostMapping("/comerciales/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		
		comercialService.deleteComercial(id);
		
		return new RedirectView("/comerciales");
	}
	
}

package online.visa.center.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import online.visa.center.model.SchengenVisa;
import online.visa.center.model.dto.SchengenVisaDto;
import online.visa.center.rest.exeption.BindingResultException;
import online.visa.center.rest.exeption.ThereIsNoSuchElementException;
import online.visa.center.service.VisaService;
import online.visa.center.service.mapper.VisaMapper;

@RestController
@RequestMapping(value = "/visa/center")
@Slf4j
public class VisaController {

	private VisaService visaService;

	@Autowired
	private VisaMapper visaMapper;

	@Autowired
	public VisaController(VisaService visaService) {
		this.visaService = visaService;
	}

	@GetMapping(value = "/visas")
	public ResponseEntity<List<SchengenVisaDto>> getVisas() {
		List<SchengenVisaDto> visas = visaMapper.toDtoList(visaService.getAllVisas());
		if (visas == null) {
			log.error("Error while retrieving visas");
			throw new ThereIsNoSuchElementException("The list of visas is empty");
		}
		return new ResponseEntity<>(visas, HttpStatus.OK);
	}

	public ResponseEntity<SchengenVisaDto> getVisa(@PathVariable Long id) {
		SchengenVisaDto visa = visaMapper.toDto(visaService.getVisa(id));
		if (visa == null) {
			log.error("Error while retrieving visa with id: " + id);
			throw new ThereIsNoSuchElementException("Visa with id " + id + " not found");
		}
		return new ResponseEntity<>(visa, HttpStatus.OK);
	}

	@PostMapping(value = "/visas")
	public ResponseEntity<SchengenVisaDto> addVisa(@Valid @RequestBody SchengenVisaDto visaDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("Error while adding visa");
			throw new BindingResultException(bindingResult.getAllErrors());
		}
		SchengenVisa visa = visaMapper.toEntity(visaDto);
		visaService.createVisa(visa);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/visas/{id}")
	public ResponseEntity<SchengenVisaDto> updateVisa(@Valid @RequestBody SchengenVisaDto visaDto, @PathVariable Long id) {
		if (visaService.getVisa(id) == null) {
			log.error("Error while updating visa with id: " + id);
			throw new ThereIsNoSuchElementException("Visa with id: " + id + " not found");
		}
		SchengenVisa visa = visaMapper.toEntity(visaDto);
		visaService.updateVisa(visa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

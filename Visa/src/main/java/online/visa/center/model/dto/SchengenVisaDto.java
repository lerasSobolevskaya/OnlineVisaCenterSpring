package online.visa.center.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.visa.center.model.enums.NumberOfEntries;
import online.visa.center.model.enums.SchengenCountries;
import online.visa.center.model.enums.VisaCategory;
import online.visa.center.model.enums.VisaStatus;
import online.visa.center.model.enums.VisaType;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SchengenVisaDto {

	@PositiveOrZero
	private Long id;

	@NotNull(message = "Number of entries can't be null")
	private NumberOfEntries entries;

	@NotNull(message = "Type can't be null")
	private VisaType type;

	@NotNull(message = "Category can't be null")
	private VisaCategory category;

	@NotNull(message = "Visa status can't be null")
	private VisaStatus visaStatus = VisaStatus.UNDER_CONSIDERATION;

	@NotNull(message = "Schengen countries can't be null")
	private SchengenCountries country;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "First date can't be null")
	private LocalDate firstDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "Last date can't be null")
	private LocalDate lastDate;

	private CustomerDataDto customerData;
}

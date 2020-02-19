package online.visa.center.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.visa.center.model.enums.Gender;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDataDto {

	@PositiveOrZero
	private Long id;

	@NotNull(message = "First name can't be null")
	@Size(max = 50, message = "The first name must contain no more than twenty characters")
	@Pattern(regexp = "(^[A-Z][a-z]{0,20})([\\-]?)([A-Z]?[a-z]{0,20})", message = "First name should begin with a capital letter")
	private String firstName;

	@NotNull(message = "Last name can't be null")
	@Size(max = 50, message = "The last name must contain no more than twenty characters")
	@Pattern(regexp = "(^[A-Z][a-z]{0,20})([\\-]?)([A-Z]?[a-z]{0,20})", message = "Last name should begin with a capital letter")
	private String lastName;

	@NotNull(message = "Patronymic can't be null")
	@Size(max = 50, message = "The patronymic must contain no more than twenty characters")
	@Pattern(regexp = "(^[A-Z][a-z]{0,20})([\\-]?)([A-Z]?[a-z]{0,20})", message = "Patronymic should begin with a capital letter")
	private String patronymic;

	@NotNull(message = "Gender can't be null")
	private Gender gender;

	@NotNull(message = "Address can't be null")
	private String address;

	private PassportDto passport;
}

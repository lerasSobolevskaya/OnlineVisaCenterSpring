package online.visa.center.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassportDto {

	@PositiveOrZero
	private Long id;

	@NotNull(message = "Passport number can't be null")
	@Pattern(regexp = "((AB|BM|HB|KH|MP|MC|KB|)(\\d{7}))", message = "The passport series or number is entered incorrectly")
	private String passportNum;

	@NotNull(message = "Issued by number can't be null")
	private String issuedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of issue number can't be null")
	private LocalDate dateOfIssue;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of expiry number can't be null")
	private LocalDate dateOfExpiry;
}

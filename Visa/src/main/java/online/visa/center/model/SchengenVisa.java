package online.visa.center.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

@Entity
@Table(name = "schengen_visa")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchengenVisa {

	@Id
	@Column(name = "visa_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PositiveOrZero
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "number_of_entries")
	@NotNull(message = "Number of entries can't be null")
	private NumberOfEntries entries;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	@NotNull(message = "Type can't be null")
	private VisaType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	@NotNull(message = "Categorycan't be null")
	private VisaCategory category;

	@Enumerated(EnumType.STRING)
	@Column(name = "visa_status")
	@NotNull(message = "Visa status can't be null")
	private VisaStatus visaStatus = VisaStatus.UNDER_CONSIDERATION;

	@Enumerated(EnumType.STRING)
	@Column(name = "schengen_countries")
	@NotNull(message = "Schengen countries can't be null")
	private SchengenCountries country;

	@Column(name = "first_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "First date can't be null")
	private LocalDate firstDate;

	@Column(name = "last_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "Last date can't be null")
	private LocalDate lastDate;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private CustomerPersonalData customerData;
}

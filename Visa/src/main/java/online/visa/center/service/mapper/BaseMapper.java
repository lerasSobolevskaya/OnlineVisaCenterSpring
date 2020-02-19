package online.visa.center.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseMapper<E, D> {

	@Autowired
	private ModelMapper mapper;

	private Class<E> entity;
	private Class<D> dto;

	public BaseMapper(Class<E> entity, Class<D> dto) {
		this.entity = entity;
		this.dto = dto;
	}

	public D toDto(E entity) {
		return entity == null ? null : mapper.map(entity, dto);
	}

	public E toEntity(D dto) {
		return dto == null ? null : mapper.map(dto, entity);
	}

	public List<D> toDtoList(List<E> entities) {
		if (entities == null) {
			return null;
		}
		if (entities.size() == 0) {
			return new ArrayList<>();
		}
		return entities.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}

	public List<E> toEntitiesList(List<D> dtoList) {
		if (dtoList == null) {
			return new ArrayList<>();
		}
		if (dtoList.size() == 0) {
			return new ArrayList<>();
		}
		return dtoList.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

}

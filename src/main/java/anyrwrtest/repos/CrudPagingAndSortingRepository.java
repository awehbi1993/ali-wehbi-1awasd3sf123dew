package anyrwrtest.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CrudPagingAndSortingRepository<T, ID> extends PagingAndSortingRepository<T, ID>, CrudRepository<T, ID> {

}
package backend.clubTable;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Danny Yip, Cobi Mom
 * 
 * a class of a club table repository
 *
 */
public interface clubTableRepository extends CrudRepository<clubTable, String> {


	
}


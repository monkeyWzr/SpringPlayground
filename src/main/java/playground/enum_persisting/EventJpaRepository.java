package playground.enum_persisting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import playground.enum_persisting.Event.Category;

public interface EventJpaRepository extends JpaRepository<Event, Integer> {

    @Query("select e from Event e where e.category = :category")
    public List<Event> findAllByCategory(@Param("category") Category category);
}

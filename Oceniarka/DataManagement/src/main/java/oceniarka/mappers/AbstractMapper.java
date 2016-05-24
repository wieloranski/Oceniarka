package oceniarka.mappers;

import java.util.List;

/**
 * Created by eryk on 08.12.15.
 */
public interface AbstractMapper<Domain, DomainFilter> {

    List<Domain> getFiltered(DomainFilter filter);

    void add(Domain domain);

    void delete(Integer id);

    void update(Domain domain);

    List<Domain> selectNLastRecords(Integer number);

}

package oceniarka.management;

import oceniarka.Domain.AbstractSqlObject;
import oceniarka.Filters.AbstractFilter;
import oceniarka.mappers.AbstractMapper;

import java.util.List;

/**
 * Created by nikodem on 08.12.15.
 */
public abstract class AbstractMgmt<Domain extends AbstractSqlObject, DomainFilter extends AbstractFilter> {

    AbstractMapper<Domain, DomainFilter> mapper;

    DomainFilter filter;

    protected AbstractMgmt() {
    }

    public abstract void setMapper();

    public List<Domain> getAll() {
        return mapper.getFiltered(null);
    }

    public Domain getById(int id) {
        filter.setId(id);
        return mapper.getFiltered(filter).get(0);
    }

    public List<Domain> getFiltered(DomainFilter filter) {
        return mapper.getFiltered(filter);
    }

    public void add(Domain domain) {
        mapper.add(domain);
    }

    public void delete(int id) {
        mapper.delete(id);
    }

    public void update(Domain domain) {
        mapper.update(domain);
    }

    List<Domain> selectNLastRecords(int i) {
        return mapper.selectNLastRecords(i);
    }


}

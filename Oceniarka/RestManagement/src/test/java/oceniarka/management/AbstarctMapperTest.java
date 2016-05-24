package oceniarka.management;

import com.google.common.collect.Lists;
import oceniarka.Domain.AbstractSqlObject;
import oceniarka.Filters.AbstractFilter;
import oceniarka.framework.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testApplicationContext.xml")
@Transactional
public abstract class AbstarctMapperTest<Domain extends AbstractSqlObject, DomainFilter extends AbstractFilter> {

    AbstractMgmt<Domain, DomainFilter> manager;

    List<Domain> insertedList;

    Domain defaultObject;

    Domain anotherDefaultObject;

    String domainName;

    List<Pair<DomainFilter, Integer>> filterExpectedSizeMap;

    public abstract void setManager();

    protected abstract void beforeInsert();

    @Before
    public void insert() {
        beforeInsert();
        for (Domain domain : insertedList) {
            manager.add(domain);
        }
        insertedList = Lists.reverse(insertedList);
        List<Domain> domainListActual = manager.selectNLastRecords(insertedList.size());

        for (int i = 0; i < insertedList.size(); ++i) {
            assertEquals(insertedList.get(i), domainListActual.get(i));
        }
    }

    @Test
    public void getAll() {
        List<Domain> domainList = manager.getAll();
        assertNotNull(domainList);
    }

    @Test
    public void getById() {
        int id = manager.selectNLastRecords(1).get(0).getId();
        Domain domain = manager.getById(id);
        assertEquals(domain.getId().intValue(), id);
    }

    @Test
    public void delete() {
        manager.add(defaultObject);
        List<Domain> domainList = manager.selectNLastRecords(1);
        int addedId = domainList.get(0).getId();
        manager.delete(addedId);
        int newId = manager.selectNLastRecords(1).get(0).getId();
        assertThat(addedId, not(newId));
    }

    @Test
    public void getFiltered() {
        for (Pair<DomainFilter, Integer> pair : filterExpectedSizeMap) {
            List<Domain> domainList = manager.getFiltered(pair.getKey());
            assertEquals(pair.getValue().intValue(), domainList.size());
        }
    }

    @Test
    public void update() {
        manager.add(defaultObject);
        int id = manager.selectNLastRecords(1).get(0).getId();
        anotherDefaultObject.setId(id);
        manager.update(anotherDefaultObject);
        assertEquals(anotherDefaultObject, manager.getById(id));
    }

}
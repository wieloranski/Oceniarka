package oceniarka.management;

import oceniarka.Domain.Opinion;
import oceniarka.Filters.OpinionFilter;
import oceniarka.mappers.OpinionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by nikodem on 07.12.15.
 */
@Component
public class OpinionMgmt extends AbstractMgmt<Opinion, OpinionFilter> {

    @Autowired
    public OpinionMapper opinionMapper;

    @Override
    @PostConstruct
    public void setMapper() {
        mapper = opinionMapper;
        filter = new OpinionFilter();
    }

}

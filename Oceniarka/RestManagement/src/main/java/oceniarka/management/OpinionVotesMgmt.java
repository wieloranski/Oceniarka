package oceniarka.management;

import oceniarka.Domain.OpinionVote;
import oceniarka.Filters.OpinionVoteFilter;
import oceniarka.mappers.OpinionVoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by nikodem on 07.12.15.
 */
@Component
public class OpinionVotesMgmt extends AbstractMgmt<OpinionVote, OpinionVoteFilter> {

    @Autowired
    OpinionVoteMapper opinionVoteMapper;

    @Override
    @PostConstruct
    public void setMapper() {
        mapper = opinionVoteMapper;
        filter = new OpinionVoteFilter();
    }


}


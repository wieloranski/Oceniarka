package oceniarka.cotrollers;

import oceniarka.Domain.AbstractSqlObject;
import oceniarka.Filters.AbstractFilter;
import oceniarka.management.AbstractMgmt;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by nikodem on 09.12.15.
 */
class ControllerHelper<T extends AbstractSqlObject> {

    private final AbstractMgmt<T, ? extends AbstractFilter> mgmt;

    private final Logger logger;

    private final String messeage;

    public ControllerHelper(
            AbstractMgmt<T, ? extends AbstractFilter> mgmt, Logger logger,
            String messeage) {
        this.mgmt = mgmt;
        this.logger = logger;
        this.messeage = messeage;
    }

    public ResponseEntity add(T t) {
        if (t != null) {
            mgmt.add(t);
            logger.info("Dodano " + messeage);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity delete(int id) {
        if (mgmt.getById(id) != null) {
            mgmt.delete(id);
            logger.info("Usunieto" + messeage);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity update(T t, int id) {
        if (mgmt.getById(id) != null) {
            t.setId(id);
            mgmt.update(t);
            logger.info("Zmieniono " + messeage);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}

package oceniarka.cotrollers;

import oceniarka.Domain.Category;
import oceniarka.Filters.CategoryFilter;
import oceniarka.management.CategoryMgmt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by nikodem on 01.11.15.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoriesController {


    private static final Logger logger = LoggerFactory.getLogger(CategoriesController.class);

    private static ControllerHelper<Category> controllerHelper;

    @Autowired
    private CategoryMgmt categoryMgmt;

    @PostConstruct
    private void buildHelper() {
        controllerHelper = new ControllerHelper<>(categoryMgmt, logger, "kategorie");
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Category>> getCategories() {
        logger.info("Zwrócono wszystkie kategorie");
        return new ResponseEntity<>(categoryMgmt.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return new ResponseEntity<>(categoryMgmt.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/filtered", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Category>> getCategoriesFiltered(@RequestBody CategoryFilter categoryFilter) {
        return new ResponseEntity<>(categoryMgmt.getFiltered(categoryFilter), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addCategory(@RequestBody Category category) {
        if (category != null) {
            categoryMgmt.add(category);
            logger.info("Dodano kategorie");
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteCategory(@PathVariable int id) {
        if (categoryMgmt.getById(id) != null) {
            categoryMgmt.delete(id);
            logger.info("Usunieto kategorie");
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateCategory(@PathVariable int id, @RequestBody Category category) {
        logger.info("Zmieniono kategorie");
        if ((categoryMgmt.getById(id) != null) && (category.getName() != null)) {
            category.setId(id);
            logger.info(category.toString());
            categoryMgmt.update(category);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Task5 {

    private static final Logger logger =
            LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {

        try {

            if (doc == null) {
                // FIX: Treat expected validation failure separately
                logger.warn("Validation failed: document is null");
                return ValidationResult.invalid("Document is null");
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                // FIX: Treat expected validation failure separately
                logger.warn("Validation failed: empty content");
                return ValidationResult.invalid("Empty content");
            }

            return runValidationRules(content);

        } catch (Exception e) {

            // FIX: Replace printStackTrace() with SLF4J logging
            logger.error("Unexpected validation error", e);

            // FIX: Return invalid result instead of null
            return ValidationResult.invalid("Unexpected validation error");
        }
    }

    public void validateBatch(List<Document> docs) {

        for (Document doc : docs) {

            ValidationResult r = validate(doc);

            // FIX: Prevent NullPointerException before calling isValid()
            if (r != null && r.isValid()) {
                saveResult(r);
            }
        }
    }
}

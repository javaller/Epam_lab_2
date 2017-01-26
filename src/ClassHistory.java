import java.lang.annotation.Documented;

/**
 * Created by Home on 26.01.2017.
 */
@Documented
public @interface ClassHistory {
    String createdBy();
    String dateCreate();
    int versionNumber();
    String modifiedBy() default "N/A";
    String dateModified() default "N/A";
    String description();
}

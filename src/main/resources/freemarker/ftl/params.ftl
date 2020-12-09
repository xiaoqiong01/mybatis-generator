
package ${entityUrl}.params;
import lombok.Data;
import ${entityUrl}.dto.${entityName};

/**
* @author
* @Date : ${createTime}
*/
@Data
public class ${entityName}Params extends ${entityName} {

    private int pageNum = 1;

    private int pageSize = 10;

}
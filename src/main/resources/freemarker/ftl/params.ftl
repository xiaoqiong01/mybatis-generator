/**
* frxs Inc.  湖南兴盛优选电子商务有限公司.
* Copyright (c) 2017-2019. All Rights Reserved.
*/
package ${entityUrl}.params;
import lombok.Data;
import ${entityUrl}.dto.${entityName};

/**
* @author xiaoqiong
* @Date : 2020年11月05日 15:47
*/
@Data
public class ${entityName}Params extends ${entityName} {

    private int pageNum = 1;

    private int pageSize = 10;

}
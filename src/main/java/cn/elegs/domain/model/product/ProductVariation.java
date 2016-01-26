package cn.elegs.domain.model.product;

import cn.elegs.domain.shared.ValueObject;

/**
 * 产品规格.
 */
public class ProductVariation extends ValueObject<ProductVariation> {

    /**
     * 名称
     */
    String name;
    /**
     * 描述
     */
    String description;
    /**
     * 数量
     */
    Double quantity;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    protected boolean sameIdentityAs(ProductVariation other) {
        return other!=null && name==other.name;
    }
}



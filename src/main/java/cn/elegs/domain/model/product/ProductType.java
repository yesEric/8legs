package cn.elegs.domain.model.product;

import cn.elegs.domain.shared.ValueObject;

import java.util.Set;

/**
 * 产品类型.
 */
public class ProductType extends ValueObject<ProductType> {

    /**
     * 名称
     */
    String name;
    /**
     * 是否实体产品
     */
    boolean isSolid;

    Set<Product> products;


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public void setSolid(boolean solid) {
        isSolid = solid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductType that = (ProductType) o;

        if (isSolid != that.isSolid) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (isSolid ? 1 : 0);
        return result;
    }

    @Override
    protected boolean sameIdentityAs(ProductType other) {
        return other!=null && name==other.name;
    }
}

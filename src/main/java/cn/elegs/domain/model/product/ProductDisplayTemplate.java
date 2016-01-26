package cn.elegs.domain.model.product;

import cn.elegs.domain.shared.ValueObject;

/**
 * 产品显示模版.
 */
public class ProductDisplayTemplate extends ValueObject<ProductDisplayTemplate> {

    /**
     * 模版名称
     */
    String name;
    /**
     * 模版URL
     */
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDisplayTemplate that = (ProductDisplayTemplate) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    protected boolean sameIdentityAs(ProductDisplayTemplate other) {
        return other!=null && name==other.name;
    }
}

package cn.elegs.domain.model.product;

import cn.elegs.domain.shared.ValueObject;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Arrays;
import java.util.Set;

/**
 * 产品类型.
 */
public class ProductCategory extends ValueObject<ProductCategory>{
    /**
     * 类型名称
     */
    @NotBlank
    String name;
    /**
     * 页面显示名称
     */
    String titleOnPage;
    /**
     * SEO 关键字
     */
    String metaKeywords;
    /**
     * SEO描述
     */
    String metaDescription;
    /**
     * 上级分类
     */
    ProductCategory parent;

    Set<ProductCategory> children;

    Set<Product> products;


    /**
     * logo
     */
    byte[] logo;
    /**
     * 排序
     */
    int sort;
    /**
     * 是否隐藏
     */
    boolean isHidden;

    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleOnPage() {
        return titleOnPage;
    }

    public void setTitleOnPage(String titleOnPage) {
        this.titleOnPage = titleOnPage;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Set<ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(Set<ProductCategory> children) {
        this.children = children;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    protected boolean sameIdentityAs(ProductCategory other) {
        return  other!=null && name.equals(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategory that = (ProductCategory) o;

        if (sort != that.sort) return false;
        if (isHidden != that.isHidden) return false;
        if (!name.equals(that.name)) return false;
        if (titleOnPage != null ? !titleOnPage.equals(that.titleOnPage) : that.titleOnPage != null) return false;
        if (metaKeywords != null ? !metaKeywords.equals(that.metaKeywords) : that.metaKeywords != null) return false;
        if (metaDescription != null ? !metaDescription.equals(that.metaDescription) : that.metaDescription != null)
            return false;
        return Arrays.equals(logo, that.logo);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (titleOnPage != null ? titleOnPage.hashCode() : 0);
        result = 31 * result + (metaKeywords != null ? metaKeywords.hashCode() : 0);
        result = 31 * result + (metaDescription != null ? metaDescription.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(logo);
        result = 31 * result + sort;
        result = 31 * result + (isHidden ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "name='" + name + '\'' +
                ", titleOnPage='" + titleOnPage + '\'' +
                '}';
    }
}

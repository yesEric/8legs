package cn.elegs.domain.model.product;

import cn.elegs.domain.shared.ValueObject;

import java.util.Arrays;
import java.util.List;

/**
 * 产品品牌.
 */
public class ProductBrand  extends ValueObject<ProductBrand>{
    /**
     * 名称
     */
    String name;
    /**
     * 描述
     */
    String description;
    /**
     * 别名
     */
    String alias;
    /**
     * Logo
     */
    byte[] logo;
    /**
     * 相关文件
     */
    List<byte[]> relatedFiles;
    /**
     * 模版页面
     */
    String pageTemplate;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public List<byte[]> getRelatedFiles() {
        return relatedFiles;
    }

    public void setRelatedFiles(List<byte[]> relatedFiles) {
        this.relatedFiles = relatedFiles;
    }

    public String getPageTemplate() {
        return pageTemplate;
    }

    public void setPageTemplate(String pageTemplate) {
        this.pageTemplate = pageTemplate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductBrand that = (ProductBrand) o;

        return name.equals(that.name);

    }

    @Override
    public String toString() {
        return "ProductBrand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", alias='" + alias + '\'' +
                ", logo=" + Arrays.toString(logo) +
                ", pageTemplate='" + pageTemplate + '\'' +
                ", titleOnPage='" + titleOnPage + '\'' +
                ", metaKeywords='" + metaKeywords + '\'' +
                ", metaDescription='" + metaDescription + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    protected boolean sameIdentityAs(ProductBrand other) {
        return other!=null && name==other.name;
    }
}

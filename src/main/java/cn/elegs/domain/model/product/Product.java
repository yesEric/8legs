package cn.elegs.domain.model.product;

import cn.elegs.domain.shared.Entity;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * 产品信息模型.
 */
public class Product extends Entity<Product> {

    /**
     * 产品名称
     */
    @NotBlank
    String name;
    /**
     * 产品编码
     */
    @NotBlank
    String code;
    /**
     * 产品描述
     */
    String description;
    /**
     * 配送模版
     */
    String freightTemplate;
    /**
     * 计量单位
     */
    @NotBlank
    String unit;
    /**
     * 数量
     */
    @NotBlank
    Double quantity;

    /**
     * 产品类型
     */
    @NotNull
    ProductCategory productCategory;

    /**
     * 产品品牌
     */
    ProductBrand productBrand;

    /**
     * 产品类型
     */
    ProductType productType;
    /**
     * 产品规格
     */
    Set<ProductVariation> variations;

    /**
     * 是否包邮
     */
    boolean isIncludeFreight;

    /**
     * 是否允许超卖
     */
    boolean isSaleForOOS;

    /**
     * 每个单位累计的会员积分
     */
    Double bpPerUnit;

    /**
     * 产品图片
     */
    byte[] images;
    /**
     * 产品展示模版
     */
    ProductDisplayTemplate productDisplayTemplate;
    /**
     * 产品搜索关键字
     */
    String keywords;
    /**
     * 配件或搭配销售
     */
    Set<Product> bundles;

    Set<ProductPrice> productPrices;

    public Set<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Set<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFreightTemplate() {
        return freightTemplate;
    }

    public void setFreightTemplate(String freightTemplate) {
        this.freightTemplate = freightTemplate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ProductBrand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }



    public boolean isIncludeFreight() {
        return isIncludeFreight;
    }

    public void setIncludeFreight(boolean includeFreight) {
        isIncludeFreight = includeFreight;
    }

    public boolean isSaleForOOS() {
        return isSaleForOOS;
    }

    public void setSaleForOOS(boolean saleForOOS) {
        isSaleForOOS = saleForOOS;
    }

    public Double getBpPerUnit() {
        return bpPerUnit;
    }

    public void setBpPerUnit(Double bpPerUnit) {
        this.bpPerUnit = bpPerUnit;
    }


    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public byte[] getImages() {
        return images;
    }

    public ProductDisplayTemplate getProductDisplayTemplate() {
        return productDisplayTemplate;
    }

    public void setProductDisplayTemplate(ProductDisplayTemplate productDisplayTemplate) {
        this.productDisplayTemplate = productDisplayTemplate;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Set<ProductVariation> getVariations() {
        return variations;
    }

    public void setVariations(Set<ProductVariation> variations) {
        this.variations = variations;
    }

    public void setIsIncludeFreight(boolean isIncludeFreight) {
        this.isIncludeFreight = isIncludeFreight;
    }

    public void setIsSaleForOOS(boolean isSaleForOOS) {
        this.isSaleForOOS = isSaleForOOS;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public Set<Product> getBundles() {
        return bundles;
    }

    public void setBundles(Set<Product> bundles) {
        this.bundles = bundles;
    }

    @Override
    public boolean sameIdentityAs(Product other) {
        return other!=null && name==other.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        if (code != null ? !code.equals(product.code) : product.code != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (freightTemplate != null ? !freightTemplate.equals(product.freightTemplate) : product.freightTemplate != null)
            return false;
        if (unit != null ? !unit.equals(product.unit) : product.unit != null) return false;
        if (quantity != null ? !quantity.equals(product.quantity) : product.quantity != null) return false;
        return productCategory.equals(product.productCategory);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (freightTemplate != null ? freightTemplate.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + productCategory.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", freightTemplate='" + freightTemplate + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                ", productCategory=" + productCategory +
                '}';
    }
}

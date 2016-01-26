package cn.elegs.domain.model.product;

import cn.elegs.domain.shared.ValueObject;

/**
 * 产品价格模型.
 */
public class ProductPrice extends ValueObject<ProductPrice> {

    /**
     * 销售价格
     */
    Double  salePrice;
    /**
     * 成本
     */
    Double cost;
    /**
     * 市场价
     */
    Double marketPrice;

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductPrice that = (ProductPrice) o;

        if (salePrice != null ? !salePrice.equals(that.salePrice) : that.salePrice != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        return marketPrice != null ? marketPrice.equals(that.marketPrice) : that.marketPrice == null;

    }

    @Override
    public int hashCode() {
        int result = salePrice != null ? salePrice.hashCode() : 0;
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (marketPrice != null ? marketPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "salePrice=" + salePrice +
                ", cost=" + cost +
                ", marketPrice=" + marketPrice +
                '}';
    }

    @Override
    protected boolean sameIdentityAs(ProductPrice other) {
        return other!=null && salePrice==other.salePrice;
    }
}

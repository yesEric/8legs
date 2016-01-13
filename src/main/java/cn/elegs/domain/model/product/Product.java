package cn.elegs.domain.model.product;

import cn.elegs.domain.model.user.User;



public class Product extends Entity<Product>{

String name;
String description;

public void setName(String name){
  this.name=name;

}

public void setDescription(String description){
  this.description=description;
}

public String getName(){
  return this.name;
}
public String getDescription(){
  return this.description;
}

@Override
public boolean sameIdentityAs(Product other) {
    return other!=null && id.equals(other.id);
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    return name.equals(product.name);

}

@Override
public int hashCode() {
    return name.hashCode();
}



}

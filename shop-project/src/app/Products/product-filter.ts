
export class ProductFilter {
  constructor(private supplier: string = '', private country: string = '',
              private type: string = '', private category: string = '') {
    this.supplier = supplier;
    this.country = country;
    this.type = type;
    this.category = category;
  }

  public get Supplier() {
    return this.supplier;
  }
  public set Supplier(value: string) {
    this.supplier = value;
  }

  public get Country() {
    return this.country;
  }
  public set Country(value: string) {
    this.country = value;
  }

  public get Type() {
    return this.type;
  }
  public set Type(value: string) {
    this.type = value;
  }

  public get Category() {
    return this.category;
  }
  public set Category(value: string) {
    this.category = value;
  }
}

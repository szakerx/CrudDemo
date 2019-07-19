import {Supplier} from '../Suppliers/Supplier';

export class ProductFilter {
  constructor(private name: string = '', private supplier: string = '', private country: string = '') {
    this.name = name;
    this.supplier = supplier;
    this.country = country;
  }

  get Name(): string {
    return this.name;
  }
  set Name(value: string) {
    this.name = value;
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
}

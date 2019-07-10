export class Product {
  constructor(public id?: number, public name?: string, public type?: string,
              public supplier?: number, public country?: string, public count?: number,
              public category?: string) {
    this.id = id;
    this.name = name;
    this.country = country;
    this.count = count;
    this.category = category;
    this.supplier = supplier;
    this.type = type;
  }
}

// Klasa odpowiadająca encji z bazy danych

import {Supplier} from '../Suppliers/Supplier';

export class Product {
  constructor(public id?: number, public name: string = '', public type: string = '',
              public supplier: Supplier = new Supplier(),
              public country: string = '', public count: number = 0,
              public category: string = '') {
    this.id = id;
    this.name = name;
    this.country = country;
    this.count = count;
    this.category = category;
    this.supplier = supplier;
    this.type = type;
  }
}

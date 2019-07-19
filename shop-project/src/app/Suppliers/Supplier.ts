
// Klasa odwzorowująca suppliera z bazy danych
import {Product} from '../Products/product';

export class Supplier {
  constructor(public id: number = 0, public name: string = '',
              public nip: string = '') {
    this.id = id;
    this.name = name;
    this.nip = nip;
  }
}

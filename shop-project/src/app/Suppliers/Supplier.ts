
// Klasa odwzorowująca suppliera z bazy danych
export class Supplier {
  constructor(public id: number, public name: string, public nip: string){
    this.id = id;
    this.name = name;
    this.nip = nip;
  }
}

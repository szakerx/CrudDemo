export class Customer {
  constructor(public id: number = 0, public firstname: string = '',
              public lastname: string = '', public login: string = '',
              public role: string = '', public active: boolean = false) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.login = login;
    this.role = role;
    this.active = active;
  }
}

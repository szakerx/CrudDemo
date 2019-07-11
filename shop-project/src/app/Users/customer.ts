export class Customer {
  constructor(public id: number = 0, public firstname: string = 'def', public lastname: string = 'def',
              public login: string = '0', public role: string = 'def') {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.login = login;
    this.role = role;
  }
}

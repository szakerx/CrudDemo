//Klasa zalogowanego usera - będzie zmienane na zgodne z security

export class CurrentUser {
  private static _user: CurrentUser = null;

  static gimmeUser(id: number, role: string): CurrentUser {
    if (this._user) {
      return this._user;
    } else {
      return this._user = new CurrentUser(id, role);
    }
  }


  private constructor(public id: number, public role: string) {
    this.id = id;
    this.role = role;
  }
}

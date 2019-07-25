import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormGroup, FormBuilder} from '@angular/forms';
import {AuthService} from '../../Guards/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  constructor(private authService: AuthService, private formBuilder: FormBuilder, private router: Router) {
  }

  loginForm: FormGroup;

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: [''],
      password: ['']
    });
  }

  get f() {
    return this.loginForm.controls;
  }

  login() {
    this.authService.login(
      {
        username: this.f.username.value,
        password: this.f.password.value
      }
    )
      .subscribe(success => {
        if (success) {
          this.router.navigate(['products']);
        } else {
          console.log('Subscribe false');
        }
      });
  }
}

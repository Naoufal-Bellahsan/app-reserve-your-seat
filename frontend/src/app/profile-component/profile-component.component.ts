import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-component',
  templateUrl: './profile-component.component.html',
  styleUrls: ['./profile-component.component.css']
})
export class ProfileComponentComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
    
  }

  volverHome() {

    this.router.navigate(['']);

  }

}

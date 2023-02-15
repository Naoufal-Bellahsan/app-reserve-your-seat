import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-languages',
  templateUrl: './languages.component.html',
  styleUrls: ['./languages.component.css']
})
export class LanguagesComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  volverHome() {

    this.router.navigate(['']);

  }

}

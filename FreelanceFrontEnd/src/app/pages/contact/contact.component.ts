import { Component } from '@angular/core';
import {ContactRequest} from "../../types/Contact-request";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  contacted: boolean = false;
  contactForm:ContactRequest = {
    userName:"",
    email:"",
    phoneNumber:"",
    message:""
  }

  contact() {

  }

  navigateToHome() {

  }

  clearForm() {

  }
}

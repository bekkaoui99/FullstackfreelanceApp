import {Component, Input} from '@angular/core';
import {FreelanceRegistrationRequest} from "../../types/FreelanceRegistration-request";
import {FreelanceResponse} from "../../types/Freelance-response";

@Component({
  selector: 'app-freelance',
  templateUrl: './freelance.component.html',
  styleUrls: ['./freelance.component.css']
})
export class FreelanceComponent {

  @Input() freelance: FreelanceResponse | undefined;

}

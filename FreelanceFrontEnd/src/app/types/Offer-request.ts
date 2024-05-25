import {ExperienceLevel} from "./ExperienceLevel";

export interface OfferRequest{
  title:string,
  description:string,
  experienceLevel:ExperienceLevel,
  publishDate:Date
  offerTechnologies:string[],
  companyName:string
}

import {ExperienceLevel} from "./ExperienceLevel";

export interface OfferResponse{
   id:string,
   title:string,
   description:string,
   experienceLevel:ExperienceLevel,
   publishDate:Date
   offerTechnologies:string[],
   companyName:string
}

//
//  ScientistDetails.swift
//  iosApp
//
//  Created by Kashif Mehmood on 01/05/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ScientistDetails: View {
    var scientist: ScientistDomainModel
    
    init(scientist: ScientistDomainModel){
        self.scientist = scientist
    }
    var body: some View {
      
        ScrollView(.vertical, showsIndicators: false) {
          VStack(alignment: .leading) {
            // HEADER
           
              ScientistRow(scientist: scientist)
            
            VStack(alignment: .leading, spacing: 0) {
                Group{
                    HeadingView(heading: "Title:")
                       DescriptionView(description: scientist.titles!)
                       Divider()
                       HeadingView(heading: "Latinized Name:")
                          DescriptionView(description: scientist.latinizedName!)
                          Divider()
                       HeadingView(heading: "Origin")
                          DescriptionView(description: scientist.origin!)
                          Divider()
                      
                   
                }
                Group{
                    HeadingView(heading: "Birth Place")
                       DescriptionView(description: scientist.birthPlace!)
                       Divider()
                    HeadingView(heading: "Date of Birth")
                       DescriptionView(description: scientist.dob!)
                       Divider()
                    HeadingView(heading: "Date of Death")
                       DescriptionView(description: scientist.dod!)
                       Divider()
                }
                Group{
                   
                    HeadingView(heading: "Books")
                    List{
                        ForEach(scientist.books! , id: \.self){book in
                            DescriptionView(description:  book)
                
                            
                        }
                    }
                   
                    
                       Divider()
                    HeadingView(heading: "Achievements")
                    DescriptionView(description:scientist.achievements?.joined(separator: "") ?? "")
                       Divider()
                }
                
              
             
              
           
            } //: VSTACK
            .padding(.horizontal, 20)
            .frame(maxWidth: 640, alignment: .center )
          } //: VSTACK
          
        } //: SCROLL
        
    }
}


//struct ScientistDetails_Previews: PreviewProvider {
//    static var previews: some View {
//        ScientistDetails(scientist: ScientistDomainModel(
//        ))
//    }
//}


struct HeadingView: View {
    var heading: String
    
    init(heading: String){
        self.heading = heading
    }
    var body: some View {
        Text(heading)
            .font(.headline)
        .fontWeight(.bold)
        .foregroundColor(.black).padding()
    }
}

struct DescriptionView: View {
    var description: String
    
    init(description: String){
        self.description = description
    }
    var body: some View {
        Text(description)
            .font(.subheadline)
        .fontWeight(.medium)
        .foregroundColor(.gray).padding()
    }
}

//
//  Corousel.swift
//  iosApp
//
//  Created by Kashif Mehmood on 27/04/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct Carousel <Content: View, scientist : ScientistDomainModel>: View{
   
    var content: (ScientistDomainModel)->Content
    var list : [ScientistDomainModel]
    
    var spacing: CGFloat
    var trailingSpace : CGFloat
    @Binding var Index: Int
    @GestureState var offset : CGFloat = 0
    @State var currentIndex: Int = 0
    
    
    init(spacing: CGFloat = 15,
         trailingSpace : CGFloat = 100,
         index: Binding<Int>,
         items: [ScientistDomainModel],
         @ViewBuilder content: @escaping (ScientistDomainModel)-> Content
         
    ){
        
        self.list = items
        self.spacing = spacing
        self.trailingSpace = trailingSpace
        self._Index = index
        self.content = content
        
    }
    
    var body: some View{
        GeometryReader{proxy in
            let width = proxy.size.width  -  (trailingSpace - spacing)
            HStack{
                ForEach(list ,id : \.id){item in
                    
                    content(item)
                        .frame(width: proxy.size.width - trailingSpace)
                    
                }
            }.padding(.horizontal,spacing)
                .offset(x:(CGFloat(currentIndex) * -width) + offset)
                .gesture(
                
                    DragGesture().updating($offset, body: {value , out , _ in
                        out = value.translation.width
                    })
                    .onEnded({ value in
                        let offsetX = value.translation.width
                        
                        let progress = -offsetX / width
                        let roundIndex = progress.rounded()
                        currentIndex += Int(roundIndex)
                        
                        currentIndex = max(min( currentIndex + Int(roundIndex), list.count - 1 ),0)
                    })
                    
                ).animation(.easeInOut, value: offset == 0)
           
            
        }
    }
    
    
}

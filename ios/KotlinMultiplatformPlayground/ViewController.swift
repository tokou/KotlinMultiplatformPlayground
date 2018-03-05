//
//  ViewController.swift
//  KotlinMultiplatformPlayground
//
//  Created by Tarek Belkahia on 15/02/2018.
//  Copyright © 2018 Tarek Belkahia. All rights reserved.
//

import UIKit
import KotlinMultiplatformPlaygroundLib

class ViewController: UIViewController {
    
    @IBOutlet var lines: UIStackView?
    @IBOutlet var state: UILabel?

    let game = KMPLGame()
    let size = KMPLGameCompanion().size

    override func viewDidLoad() {
        super.viewDidLoad()
        state?.text = "Next player: \(game.nextPlayer)"
        (0..<size).forEach { x in
            let line = UIStackView()
            line.spacing = 10
            line.distribution = .fillEqually
            line.axis = .horizontal
            (0..<size).forEach { y in
                let cell = UIButton()
                cell.backgroundColor = UIColor.lightGray
                cell.tag = Int(x)
                cell.addTarget(self, action: #selector(makeMove(_:)), for: .touchUpInside)
                line.addArrangedSubview(cell)
            }
            lines?.addArrangedSubview(line)
        }
    }
    
    @objc func makeMove(_ sender: UIButton) {
        let x = sender.tag
        let y = lines?.subviews[x].subviews.index(of: sender)
        let player = game.nextPlayer
        if !game.isFinished() {
            game.move(position: KMPLStdlibPair(first: x, second: y))
            sender.setTitle(String(describing: player), for: .disabled)
            sender.isEnabled = false
            state?.text = "Next player: \(game.nextPlayer)"
        }
        if game.isFinished() {
            if game.isDraw() {
                state?.text = "Draw!"
            } else {
                state?.text = "Player \(String(describing: game.winner!)) won!"
            }
        }
    }
}


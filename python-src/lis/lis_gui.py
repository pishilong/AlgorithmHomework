#!/usr/bin/python
# -*- coding: utf-8 -*-

"""
File: lis_gui.py
Author: Pishilong
Description: lis gui class
"""

import sys
import lis
from PyQt4.QtCore import *
from PyQt4.QtGui import *
QTextCodec.setCodecForTr(QTextCodec.codecForName("utf8"))

class LisGui(QWidget):

    def __init__(self):
        super(LisGui, self).__init__()

        self.initUI()

    def initUI(self):
        raw = QLabel(self.tr("输入(请用空格分隔数字)"))
        result = QLabel(self.tr("结果"))

        self.rawEdit = QLineEdit()
        self.resultEdit = QLineEdit()
        self.resultEdit.setReadOnly(True)

        okButton = QPushButton(self.tr("计算"))
        resetButton = QPushButton(self.tr('重置'))
        okButton.clicked.connect(self.caculateLis)
        resetButton.clicked.connect(self.resetEdit)

        grid = QGridLayout()

        grid.addWidget(raw, 1, 0)
        grid.addWidget(self.rawEdit, 1, 1)

        grid.addWidget(result, 2, 0)
        grid.addWidget(self.resultEdit, 2, 1)

        grid.addWidget(okButton, 3, 0)
        grid.addWidget(resetButton, 3, 1)

        self.setLayout(grid)

        self.setGeometry(300, 300, 350, 300)
        self.setWindowTitle(self.tr('寻找最长递增子序列'))
        self.show()

    def resetEdit(self):
        self.rawEdit.clear()
        self.resultEdit.clear()

    def caculateLis(self):
        input_string = self.rawEdit.text()
        input_string = map(int, input_string.split(' '))
        result = lis.lis(input_string)
        self.resultEdit.setText(result)


def main():
    app = QApplication(sys.argv)
    list_gui = LisGui()
    sys.exit(app.exec_())


if __name__ == '__main__':
    main()
